package org.example;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {
    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
        System.out.println("before");
    }


    @After
    public void after() {
        System.out.println("after");
    }

    @BeforeClass
    public static void bc() {
        System.out.println("before class");
    }

    @AfterClass
    public static void ac() {
        System.out.println("after class");
    }


    @Parameters
    public static Collection<Object[]> data() {
        String fileName = "../resources/testinput.txt";
        File file = new File(fileName);
        List<Object[]> list = new LinkedList<>();
        // 读取文件内容到Stream流中，按行读取
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            // 随机行顺序进行数据处理
            String len = null;
            while ((len = br.readLine()) != null) {
                String[] parts = len.split(",");
                list.add(Arrays.asList(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])).toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public int Input;

    public int Expected;

    public SolutionTest(int input, int expected) {
        Input = input;
        Expected = expected;
    }

    @Test
    public void test() {
        Assert.assertEquals(Expected, Solution.MaxProduct(Input));
    }

}