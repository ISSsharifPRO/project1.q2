package java_final_project;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class My_Set implements Set {
    private int size;
    private Object[] ob=new Object[0];
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)
        return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        for(Object p:this){
            if (p.equals(o))
                remove(o);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (!add(o)){
                Object[] pp = new Object[ob.length+1];
                for(int j=0; j<size; j++){
                    pp[j]=ob[j];
                }
                pp[ob.length]=o;
                size++;
                ob=pp;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int h=0;
        for (h=0; h<ob.length; h++){
            if (ob[h].equals(o)){
                if (h<=size){
                    Object[] pp=new Object[size-1];
                    for (int y=0; y<h; y++){
                        pp[y]=ob[y];
                    }
                    for (int y=h+1; y<size; y++){
                        pp[y-1]=ob[y];
                    }
                    ob=pp;
                }
                break;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object o:collection){
            add(o);
        }
        return false;
    }

    @Override
    public void clear() {
        for (Object o:this){
            remove(o);
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        for (Object o:collection){
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        Boolean b=false;
        for (Object o:collection){
            for(int t=0; t<ob.length; t++){
                if (ob[t].equals(o))
                    b=true;
            }
        }
        return b;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return ob;
    }
}
