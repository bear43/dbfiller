package com.hiber.Generator;

import com.hiber.DBClass.*;
import com.hiber.Util.Picker;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FullUnitGenerator
{
    private SpentType[] types;

    public void generateTypes(int count)
    {
        types = new SpentType[count];
        for(int i = 0; i < count; i++)
            types[i] = SpentTypeGenerator.generateSpentTypeEx();
    }

    public Unit generate(int employeeCount, int checkCount, int limitCount)
    {
        Generator generator = new Generator();
        Department department = DepartmentGenerator.generateDepartmentEx();
        Employee[] employees = new Employee[employeeCount];
        Limit[] limits = new Limit[limitCount];
        Map<SpentType, Limit> map = new HashMap<SpentType, Limit>();
        for(int i = 0; i < types.length; i++)
            map.put(types[i], LimitGenerator.generateLimit());
        Limit limit;
        SpentType spentType;
        Check check;
        for(int i = 0; i < employeeCount; i++)
        {
            employees[i] = EmployeeGenerator.generateEmployeeEx();
            for(int j = 0; j < checkCount; j++)
            {
                spentType = (SpentType)Picker.pickFromCollection(Arrays.asList(types));
                check = CheckGenerator.generateCheck();
                check.setSpentType(spentType);
                check.setEmployee(employees[i]);
                limit = map.get(spentType);
                limit.setTotal(limit.getTotal() + check.getTotal());
                check.setDate(generator.generateDate(limit.getStartDate(), limit.getEndDate()));
                employees[i].getCheckSet().add(check);
            }
            employees[i].setDepartment(department);
        }
        Collection c = map.values();
        System.arraycopy(c.toArray(), 0, limits, 0, c.size());
        for(int i = c.size(); i < limitCount; i++)
            limits[i] = LimitGenerator.generateLimit();
        for(Map.Entry<SpentType, Limit> entry : map.entrySet())
            department.addLimit(entry.getValue(), entry.getKey());
        department.getEmployees().addAll(Arrays.asList(employees));
        return new Unit(department, types, limits);
    }

    public SpentType[] getTypes()
    {
        return types;
    }

    public void setTypes(SpentType[] types)
    {
        this.types = types;
    }
}
