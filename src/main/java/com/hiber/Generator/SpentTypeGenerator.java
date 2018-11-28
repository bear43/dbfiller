package com.hiber.Generator;

import com.hiber.DBClass.SpentType;
import com.hiber.Util.Picker;

import java.util.HashMap;
import java.util.Map;

public class SpentTypeGenerator extends SkeletonGenerator
{
    private static final Map<String, String> typesPull = new HashMap<>();

    static
    {
        reset();
    }

    public static void reset()
    {
        typesPull.put("Service", "Servicing some devices and peripherals");
        typesPull.put("Security", "Security the office and software");
        typesPull.put("Communications", "Set new communications with companies");
        typesPull.put("Banking", "Save some money for fun, pay loans, taxes etc");
        typesPull.put("Managing", "Releasing money for management goals");
        typesPull.put("Flexing", "Fun and flex");
        typesPull.put("Learning", "Learning students and teachers");
        typesPull.put("Hating", "For clowns and pricks");
        typesPull.put("Alcho", "For drinks. Hot drinks if you got it :P");
        typesPull.put("Drugs", "Drugs for ill people, not for stoned");
        typesPull.put("Medicine", "Pills, balls");
    }

    public static SpentType generateSpentType()
    {
        return new SpentType(generator.generateString(), generator.generateString());
    }

    public static SpentType generateSpentTypeEx()
    {
        Map.Entry<String, String> entry = (Map.Entry<String, String>)Picker.pickFromCollection(typesPull.entrySet());
        SpentType type = new SpentType(entry.getKey(), entry.getValue());
        typesPull.remove(entry.getKey());
        return type;
    }
}
