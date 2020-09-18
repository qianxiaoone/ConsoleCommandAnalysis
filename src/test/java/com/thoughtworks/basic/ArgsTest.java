package com.thoughtworks.basic;

import ConsoleCommandAnalysis.Args;
import ConsoleCommandAnalysis.KeyValuePair;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArgsTest {
    @Test
    public void should_return_string_list_when_scan_given_string(){
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Args args = new Args(argsText);

        //when
        List<KeyValuePair> KeyValuePairs = args.scan();

        //then
        Assert.assertEquals(3, KeyValuePairs.size());
//        Assert.assertEquals(true, keyValueString.contains("l true"));
//        Assert.assertEquals(true, keyValueString.contains("p 8080"));
//        Assert.assertEquals(true, keyValueString.contains("d usr/logs"));
//        Assert.assertEquals(true, new KeyValuePair("l","true"));
    }
}
