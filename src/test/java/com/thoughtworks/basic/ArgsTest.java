package com.thoughtworks.basic;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgsTest {
    @Test
    public void should_return_string_list_when_scan_given_string() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<String> keyValues=args.scan();
        //then
        assertEquals(3,keyValues.size());
        assertTrue(keyValues.contains("l true"));
    }
    @Test
    public void should_return_keyValues_list_when_keyValuesScan_given_string() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<String> keyValues=args.scan();
        List<KeyValuePair> keyValuePair=args.keyValueScan(keyValues);
        //then
        assertEquals(3,keyValuePair.size());
        assertTrue(keyValuePair.contains(new KeyValuePair("l","true")));
        assertTrue(keyValuePair.contains(new KeyValuePair("p","8080")));
        assertTrue(keyValuePair.contains(new KeyValuePair("d","/usr/logs")));
    }

    @Test
    public void should_return_true_list_when__given_l() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<KeyValuePair> keyValuePair=args.keyValueScan(args.scan());
        //then
        assertEquals(3,keyValuePair.size());
        assertTrue(keyValuePair.contains(new KeyValuePair("l","true")));
        assertTrue(keyValuePair.contains(new KeyValuePair("p","8080")));
        assertTrue(keyValuePair.contains(new KeyValuePair("d","/usr/logs")));
    }

    @Test
    public void should_return_boolean_true_when_given_l() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        Object value=args.getValueOf("l");
        //then
        assertEquals(true,value);
    }
    @Test
    public void should_return_integer_8080_when_given_p() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        Object value=args.getValueOf("p");
        //then
        assertEquals(8080,value);
    }
    @Test
    public void should_return_String_when_given_d() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        Object value=args.getValueOf("d");
        //then
        assertEquals("/usr/logs",value);
    }

    @Test
    public void should_return_error_list_when_keyValuesScan_given_two_l() {
        //given
        String argsText="-l true -l true -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<String> keyValues=args.scan();
        List<KeyValuePair> keyValuePair=args.keyValueScan(keyValues);
        //then  会抛出错误
    }

    @Test
    public void should_return_default_list_when_keyValuesScan_given_l_null() {
        //given
        String argsText="-l -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<String> keyValues=args.scan();
        List<KeyValuePair> keyValuePair=args.keyValueScan(keyValues);
        //then
        assertEquals(2,keyValuePair.size());
        assertTrue(keyValuePair.contains(new KeyValuePair("l","false")));
        assertTrue(keyValuePair.contains(new KeyValuePair("d","/usr/logs")));
    }
}
