package test.ui;

import hangman.ui.CharMatrix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test CharMatrix class.
 */
public class CharMatrixTest {

    @Test
    public void testCharMatrixFromValidString() {
        String validString = "1234\n4321\n2314";
        CharMatrix charMatrix = new CharMatrix(validString);
        assertTrue(charMatrix.getHeight() == 3);
        assertTrue(charMatrix.getWidth() == 4);
        assertEquals("1234", charMatrix.getRow(0));
        assertEquals("4321", charMatrix.getRow(1));
        assertEquals("2314", charMatrix.getRow(2));
        assertEquals(validString, charMatrix.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCharMatrixFromInvalidStringNonConsistentRowLength() {
        String invalidString = "1234\n123\n123";
        CharMatrix charMatrix = new CharMatrix(invalidString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCharMatrixFromInvalidStringNull() {
        String invalidString = null;
        CharMatrix charMatrix = new CharMatrix(invalidString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCharMatrixFromInvalidStringEmpty() {
        String invalidString = "";
        CharMatrix charMatrix = new CharMatrix(invalidString);
    }

    @Test
    public void testSetSubMatrixValidCharMatrix() {
        String initialString = "12345\n54321\n51423\n21345";
        CharMatrix charMatrix = new CharMatrix(initialString);
        String subMatrixString = "***\n***\n***";
        CharMatrix subCharMatrix = new CharMatrix(subMatrixString);
        charMatrix.setSubMatrix(subCharMatrix, 0, 1);
        assertEquals("1***5", charMatrix.getRow(0));
        assertEquals("5***1", charMatrix.getRow(1));
        assertEquals("5***3", charMatrix.getRow(2));
        assertEquals("21345", charMatrix.getRow(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetSubMatrixInvalidCharMatrixIndexOutOfBounds() {
        String initialString = "12345\n54321\n51423\n21345";
        CharMatrix charMatrix = new CharMatrix(initialString);
        String subMatrixString = "***\n***\n***";
        CharMatrix subCharMatrix = new CharMatrix(subMatrixString);
        charMatrix.setSubMatrix(subCharMatrix, 3, 3);
    }

}
