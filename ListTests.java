import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class ListTests {
    StringChecker strk = new StringChecker() {
        public boolean checkString(String s) {
            if(s.equals("")) return false;
            return s.compareTo("z") >= 0;
        }
    };

    @Test
    public void testFilterEmpty() {
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<String> result = (ArrayList<String>)ListExamples.filter(strList, strk);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {}, arr);
    }

    @Test    
    public void testFilterUnique() {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("abacus");
        strList.add("berserk");
        strList.add("zorn");
        strList.add("zodd");
        ArrayList<String> result = (ArrayList<String>)ListExamples.filter(strList, strk);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {"zorn", "zodd"}, arr);
    }

    @Test
    public void testFilterMany() {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("zack");
        strList.add("argyle");
        strList.add("argyle");
        strList.add("zack");
        ArrayList<String> result = (ArrayList<String>)ListExamples.filter(strList, strk);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {"zack", "zack"}, arr);
    }

    @Test
    public void testMergeEmpty() {
        ArrayList<String> strList1 = new ArrayList<String>();
        ArrayList<String> strList2 = new ArrayList<String>();
        ArrayList<String> result = (ArrayList<String>)ListExamples.merge(strList1, strList2);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {}, arr);
    }

    @Test
    public void testMergeAsync() {
        ArrayList<String> strList1 = new ArrayList<String>();
        strList1.add("argyle");
        strList1.add("grinder");
        ArrayList<String> strList2 = new ArrayList<String>();
        strList2.add("burnt");
        strList2.add("scorn");
        strList2.add("vall");
        ArrayList<String> result = (ArrayList<String>)ListExamples.merge(strList1, strList2);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {"argyle", "burnt", 
        "grinder", "scorn", "vall"}, arr);
    }

    @Test
    public void testMergeSymm() {
        ArrayList<String> strList1 = new ArrayList<String>();
        strList1.add("argyle");
        strList1.add("grinder");
        strList1.add("zack");
        ArrayList<String> result = (ArrayList<String>)ListExamples.merge(strList1, strList1);
        String[] arr = result.toArray(new String[0]);
        assertArrayEquals(new String[] {"argyle", "argyle", 
        "grinder", "grinder", "zack", "zack"}, arr);
    }
}