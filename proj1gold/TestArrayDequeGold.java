import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> studentArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionArray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i += 1) {
            int addNumber = StdRandom.uniform(1000);
            if (solutionArray.size() == 0) {
                int firstOrLast = StdRandom.uniform(2);
                if (firstOrLast == 0) {
                    studentArray.addFirst(addNumber);
                    solutionArray.addFirst(addNumber);
                    log = log + "addFirst(" + addNumber + ")\n";
                } else {
                    studentArray.addLast(addNumber);
                    solutionArray.addLast(addNumber);
                    log = log + "addLast(" + addNumber + ")\n";
                }
            } else {
                Integer expected, actual;
                int selections = StdRandom.uniform(4);
                switch (selections) {
                    case 0:
                        studentArray.addFirst(addNumber);
                        solutionArray.addFirst(addNumber);
                        log = log + "addFirst(" + addNumber + ")\n";
                        break;
                    case 1:
                        studentArray.addLast(addNumber);
                        solutionArray.addLast(addNumber);
                        log = log + "addLast(" + addNumber + ")\n";
                        break;
                    case 2:
                        actual = studentArray.removeFirst();
                        expected = solutionArray.removeFirst();
                        log = log + "removeFirst()\n";
                        assertEquals(log, expected, actual);
                        break;
                    case 3:
                        actual = studentArray.removeLast();
                        expected = solutionArray.removeLast();
                        log = log + "removeLast()\n";
                        assertEquals(log, expected, actual);
                        break;
                }
            }
        }
    }
}
