package com.thoughtworks.basic;

import ConsoleCommandAnalysis.Args;
import ConsoleCommandAnalysis.Arg;
import ConsoleCommandAnalysis.FlagSchema;
import ConsoleCommandAnalysis.Schema;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArgsTest {
    @Test
    public void should_return_size_3_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);

        //when
        Args args = new Args(argsText, schema);

        //then
        Assert.assertEquals(3, args.getArgSet().size());
    }

    @Test
    public void should_return_true_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String l = args.getValueOf("l");

        //then
        Assert.assertEquals("true", l);
    }
}
