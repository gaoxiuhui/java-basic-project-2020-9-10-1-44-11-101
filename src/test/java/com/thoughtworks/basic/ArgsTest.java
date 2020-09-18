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
        List<KeyValuePair> keyValuePair=args.keyValueScan();
        //then
        assertEquals(3,keyValuePair.size());
        assertTrue(keyValuePair.contains(new KeyValuePair("l","true")));
        assertTrue(keyValuePair.contains(new KeyValuePair("p","8080")));
        assertTrue(keyValuePair.contains(new KeyValuePair("d","/usr/logs")));
    }
}
