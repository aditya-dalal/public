package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class Handler
{
    private List<Employee> free;

    public Handler()
    {
        free = new ArrayList<Employee>();
    }

    public synchronized void addToFreeList(Employee emp)
    {
        free.add(emp);
    }

    public synchronized Employee getFreeEmployee()
    {
        Employee tl = null;
        Employee pm = null;

        for(Employee emp : free)
        {
            if(emp.designation() == Designation.FRESHER)
            {
                free.remove(emp);
                return emp;
            }
            else if(emp.designation() == Designation.TL)
                tl = emp;
            else if(emp.designation() == Designation.PM)
                pm = emp;
        }
        if(tl != null)
        {
            free.remove(tl);
            return tl;
        }
        if(pm != null)
        {
            free.remove(pm);
            return pm;
        }
        return null;
    }
}
