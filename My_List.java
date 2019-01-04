package java_final_project;

import java.util.*;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class My_List extends AbstractCollection implements List{

    private int size=0;
    private Object[] ob;
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        if (this.size()==0)
            return true;
        else
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object o1:this){
            if (o1.equals(o))
                this.remove(o);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] re = new Object[this.size()];
        for (int i=0; i<this.size(); i++){
            re[i]= this.get(i);
        }
        return re;
    }

    @Override
    public boolean add(Object o) {
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Boolean b=false;
        for(Object p:this){
            if (o.equals(p))
                b=true;
        }
        return b;
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object c:collection){
            add(c);
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        for(Object o:collection){
            add(i,o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection collection) {
        for (Object o:this){
           for (Object p:collection){
                if (o.equals(p)){
                    this.remove(o);
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        for (Object c:collection){
            remove(c);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {

        return false;
    }

    @Override
    public void clear() {
        for(Object o:this){
            remove(o);
        }
    }

    @Override
    public Object get(int i) {
        return ob[i];
    }


    @Override
    public Object set(int i, Object o) {
        ob[i]=o;
        return null;
    }

    @Override
    public void add(int i, Object o) {
        if (!add(o)){
            if (i>size){
                Object[] pp = new Object[i+1];
                for(int j=0; j<size; j++){
                    pp[j]=ob[j];
                }
                pp[i]=o;
                size++;
                ob=pp;

            }else {
                ob[i]=o;
            }
        }
    }

    @Override
    public Object remove(int i) {
        if (i<=size){
            Object[] pp=new Object[size-1];
            for (int y=0; y<i; y++){
                pp[y]=ob[y];
            }
            for (int y=i+1; y<size; y++){
                pp[y-1]=ob[y];
            }
            ob=pp;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Boolean b=false;
        int p=0;
        for(p=0; p<this.size(); p++){
            if (o.equals(this.get(p))) {
                b = true;
                break;
            }
        }
        if (b){
            return p;
        }else return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Boolean b=false;
        int p=0;
        for(p=0; p<this.size(); p++){
            if (o.equals(this.get(p)))
                b = true;
        }
        if (b){
            return p;
        }else return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        Object[] re=new Object[0];
        for (Object o:this){
            Object[] p=re;
            re=new Object[re.length+1];
            int i=0;
            for (i=0; i<re.length-1; i++){
                re[i]=p[i];
            }
            re[i]=p[i];
        }
        return re;
    }
}
