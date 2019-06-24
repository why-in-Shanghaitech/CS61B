import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testAddFirstRemoveFirst() {
        /** Making random calls to addFirst(), removeFirst() */
        StudentArrayDeque<Integer>  stu;
        ArrayDequeSolution<Integer> exp;
        int size;
        Integer randomNum;

        // 1000 random calls
        stu = new StudentArrayDeque<>();
        exp = new ArrayDequeSolution<>();
        size = 0;
        String strMessage = "";

        for (int i = 0; i < 1000; i++) {

            if (StdRandom.bernoulli() && size > 0) {
                assertEquals(strMessage + "removeFirst()", exp.removeFirst(), stu.removeFirst());
                strMessage += "removeFirst()\n";
                size--;

            } else {
                randomNum = StdRandom.uniform(999);
                stu.addFirst(randomNum);
                exp.addFirst(randomNum);
                strMessage += "addFirst(" + randomNum + ")\n";
                size++;
            }
        }
    }

    @Test
    public void testAddRemove() {
        /** Making random calls to addFirst(), addLast(), removeFirst(),
         removeLast() */
        StudentArrayDeque<Integer>  stu;
        ArrayDequeSolution<Integer> exp;
        int size;
        Integer randomNum;

        // 1000 random calls
        stu = new StudentArrayDeque<>();
        exp = new ArrayDequeSolution<>();
        size = 0;
        String strMessage = "";

        for (int i = 0; i < 1000; i++) {

            if (StdRandom.bernoulli() && size > 0) { // remove operations

                if (StdRandom.bernoulli()) { // removeFirst
                    assertEquals(strMessage + "removeFirst()",
                                 exp.removeFirst(), stu.removeFirst());
                    strMessage += "removeFirst()\n";

                } else {
                    assertEquals(strMessage + "removeLast()",
                                 exp.removeLast(), stu.removeLast());
                    strMessage += "removeLast()\n";

                }

                size--;

            } else { // add operations

                randomNum = StdRandom.uniform(999);

                if (StdRandom.bernoulli()) { // addFirst
                    stu.addFirst(randomNum);
                    exp.addFirst(randomNum);
                    strMessage += "addFirst(" + randomNum + ")\n";

                } else { // addLast
                    stu.addLast(randomNum);
                    exp.addLast(randomNum);
                    strMessage += "addLast(" + randomNum + ")\n";

                }

                size++;
            }
        }
    }
}
