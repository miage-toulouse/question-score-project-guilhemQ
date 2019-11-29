package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;
    private List<Integer> list;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple avec une liste
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(7);
        question = new QuestionAChoixMultiple("un énoncé", list);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = question.getEnonce();
        // then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // when : quand l'étudiant fourni l'indice d'une bonne réponse
        int indiceEtudiant = 1;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100/3 puisqu'il y a 3 bonnes réponses à l'énoncé
        assertEquals(100f/3, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : quand l'étudiant fourni l'indice d'une mauvaise réponse
        int indiceEtudiant = 2;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }
}