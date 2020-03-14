package com.example.demo;

import com.example.demo.game.Army;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;


    public class JsonParser {
        public static Army parseToArmy(String object) {
            ObjectMapper mapper = new ObjectMapper();
            Army army;
            Gson gson = new Gson();



            try {
                army = gson.fromJson(object,Army.class);
                return army;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        public static String parseToJson(Object f){
            String jsonInString= null;
            try{
                ObjectMapper mapper = new ObjectMapper();



                jsonInString = mapper.writeValueAsString(f);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return jsonInString;
        }
    }

