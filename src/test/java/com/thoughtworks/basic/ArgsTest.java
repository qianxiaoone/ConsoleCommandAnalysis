package com.thoughtworks.basic;

import ConsoleCommandAnalysis.Args;
import ConsoleCommandAnalysis.Arg;
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
        List<Arg> Args = args.scan();

        //then
        Assert.assertEquals(3, Args.size());
        System.out.println(Args);
//        Assert.assertEquals("Arg{key='l', value='true'}", new Arg("l","true").toString());
    }
}
