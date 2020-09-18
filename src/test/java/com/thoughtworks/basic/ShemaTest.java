package com.thoughtworks.basic;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ShemaTest {
    @Test
    public void should_return_boolean_when_given_flag_l() {
        //given
        Set<FlagSchema> flagSchemas=new HashSet<>();
        flagSchemas.add(new FlagSchema("l",Boolean.TYPE));
        Schema schema=new Schema(flagSchemas);
        //when
        Object type = schema.getTypeOf("l");
        //then
        assertEquals(Boolean.TYPE,type);
    }
    @Test
    public void should_return_integer_when_given_flag_p() {
        //given
        Set<FlagSchema> flagSchemas=new HashSet<>();
        flagSchemas.add(new FlagSchema("p",Integer.TYPE));
        Schema schema=new Schema(flagSchemas);
        //when
        Object type = schema.getTypeOf("p");
        //then
        assertEquals(Integer.TYPE,type);
    }
    @Test
    public void should_return_string_when_given_flag_d() {
        //given
        Set<FlagSchema> flagSchemas=new HashSet<>();
        flagSchemas.add(new FlagSchema("d",String.class.getTypeName()));
        Schema schema=new Schema(flagSchemas);
        //when
        Object type = schema.getTypeOf("d");
        //then
        assertEquals(String.class.getTypeName(),type);
    }

}
