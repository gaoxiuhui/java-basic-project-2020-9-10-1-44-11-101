package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Args {


    private String argsText;

    public Args(String argsText) {

        this.argsText = argsText;
    }

    public List<String> scan() {
        List<String> keyValues=Arrays.asList(argsText.split("-"));
        keyValues=keyValues.stream()
                .map(String::trim)
                .collect(Collectors.toList());
        return keyValues.subList(1,keyValues.size());
    }

    public List<KeyValuePair> keyValueScan(List<String> keyValues) {
        List<KeyValuePair> keyValuePairs=new ArrayList<>();
        keyValues.forEach(keyValue ->{
            String[] splitKeyValue=keyValue.split(" ");
            String key=splitKeyValue[0];
            String value=splitKeyValue[1];
            keyValuePairs.add(new KeyValuePair(key,value));
        });
        return keyValuePairs;
    }

    public Object getValueOf(String flag){
        List<KeyValuePair> keyValuePairs=keyValueScan(scan());
        for(int i = 0; i < keyValuePairs.size();i++){
            if(keyValuePairs.get(i).getKey().equals(flag)){
                 Object value=keyValuePairs.get(i).getValue();
                return getObjectValue(flag,String.valueOf(value));
            }
        }
        return null;
    }

    public Object getObjectValue(String flag,String value) {
        if (flag.equals("l")) {
            return Boolean.parseBoolean(value);
        }
        if (flag.equals("p")) {
            return Integer.parseInt(value);
        }
        if (flag.equals("d")) {
            return String.valueOf(value);
        }
        return null;
    }
}
