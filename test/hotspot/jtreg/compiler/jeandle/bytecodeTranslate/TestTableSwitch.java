
/*
 * @test
 * @library /test/lib
 * @build jdk.test.lib.Asserts
 * @run main/othervm -XX:-TieredCompilation -Xcomp -Xbatch
 *      -XX:CompileCommand=compileonly,compiler.jeandle.bytecodeTranslate.TestTableSwitch::minPositiveSwitch
 *      -XX:CompileCommand=compileonly,compiler.jeandle.bytecodeTranslate.TestTableSwitch::zeroCrossSwitch
 *      -XX:CompileCommand=compileonly,compiler.jeandle.bytecodeTranslate.TestTableSwitch::largeRangeSwitch
 *      -XX:+UseJeandleCompiler compiler.jeandle.bytecodeTranslate.TestTableSwitch
 */

package compiler.jeandle.bytecodeTranslate;

import jdk.test.lib.Asserts;

public class TestTableSwitch{
    public static void main(String[] args) throws Exception {
        preInit();
        testBasicBoundaryScenarios();
        testLargeRangeSwitch();
    }

    // Pre-initialize required classes (consistent with TestTypeConversion)
    private static void preInit() throws Exception {
        Class.forName("java.lang.Byte");
        Class.forName("java.lang.Character");
        Class.forName("java.lang.Short");
        Class.forName("java.lang.Integer");
        Class.forName("java.lang.Long");
        Class.forName("java.lang.Float");
        Class.forName("java.lang.Double");
        Class.forName("jdk.test.lib.Asserts");
    }

    public static int minPositiveSwitch(int num){
        switch(num){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            default: return -100;
        }
    }
    
    public static int zeroCrossSwitch(int num){
        switch(num){
            case -1: return -1;
            case 0: return 0;
            case 1: return 1;
            default: return -100;
        }
    }

    private static void testBasicBoundaryScenarios(){
        Asserts.assertEquals(minPositiveSwitch(0),-100);
        Asserts.assertEquals(minPositiveSwitch(1),1);
        Asserts.assertEquals(minPositiveSwitch(2),2);
        Asserts.assertEquals(minPositiveSwitch(3),3);

        Asserts.assertEquals(minPositiveSwitch(-2),-100);
        Asserts.assertEquals(minPositiveSwitch(-1),-1);
        Asserts.assertEquals(minPositiveSwitch(0),0);
        Asserts.assertEquals(minPositiveSwitch(1),1);
        Asserts.assertEquals(minPositiveSwitch(2),-100);
    }

    public static int largeRangeSwitch(int num){
        switch(num){
            case 1000: return 1000;
            case 1001: return 1001;
            case 1002: return 1002;
            default: return -100;
        }
    }

    private static void testLargeRangeSwitch(){
        Asserts.assertEquals(largeRangeSwitch(999),-100);
        Asserts.assertEquals(largeRangeSwitch(1000),1000);
        Asserts.assertEquals(largeRangeSwitch(1001),1001);
        Asserts.assertEquals(largeRangeSwitch(1002),1002);
        Asserts.assertEquals(largeRangeSwitch(2001),-100);
    }
    
}
