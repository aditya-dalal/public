package GooglePractice.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyList<Type> implements Iterable<Type>
{
    private List<Type> list = new ArrayList<Type>();

    public MyList(List<Type> list)
    {
        this.list = list;
    }

    public Iterator<Type> iterator()
    {
        Iterator<Type> iterator = new Iterator<Type>()
        {
            int currentIndex = 0;

            public boolean hasNext()
            {
                return currentIndex < list.size() && list.get(currentIndex) != null;
            }

            public Type next()
            {
                if(!hasNext())
                    return null;
                return list.get(currentIndex++);
            }

            public void remove() {
                //ToDo
            }
        };
        return iterator;
    }
}
