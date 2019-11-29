package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreCalculateur;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        // given : une instance du calculateur de score
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        scoreCalculateur = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScoreQuestionForBonnesReponses() {
        // when : on calcule le score en fonction des indices fournis par l'étudiant qui ne donne QUE DES BONNES REPONSES
        float score = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3,5)), questionAChoixMultiple);
        // then : le score obtenu est 100
        assertEquals(100f, score, 0.01f);
    }

    @Test
    public void testCalculeScoreQuestionForMauvaisesReponses() {
        // when : on calcule le score en fonction des indices fournis par l'étudiant qui ne donnent QUE DES MAUVAISES REPONSES
        float score = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(1,4)), questionAChoixMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, score, 0.01f);
    }

    @Test
    public void testCalculeScoreQuestionForDeuxBonnesReponses() {
        // when : on calcule le score en fonction des indices fournis par l'étudiant qui ne donnent 2 bonnes réponses
        float score = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3)), questionAChoixMultiple);
        // then : le score obtenu est 2*100f/3
        assertEquals(2*100f/3, score, 0.01f);
    }


}