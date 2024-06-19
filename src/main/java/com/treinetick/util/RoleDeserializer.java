//package com.treinetick.util;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.treinetick.model.Role;
//
//import java.io.IOException;
//
//public class RoleDeserializer extends JsonDeserializer<Role> {
//
//    @Override
//    public Role deserialize(JsonParser p, DeserializationContext ctxt)
//            throws IOException, JsonProcessingException {
//        int value = p.getIntValue();
//        return Role.fromValue(value);
//    }
//}
//
