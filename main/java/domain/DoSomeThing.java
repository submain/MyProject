package domain;

import java.util.ArrayList;
import java.util.List;

public class DoSomeThing<T> {
    
    public DoSomeThing(List<TaskT<T>> list){
        this.list = list;
    }
    List<TaskT<T>> list;
	public static Integer sqrt(String numStr) {
		return Integer.valueOf(numStr);
	}
	
	
	
	public List<TaskT<T>> getList() {
        return list;
    }



    public void setList(List<TaskT<T>> list) {
        this.list = list;
    }



    public static void main(String[] args) {
        List<TaskT<Integer>> list = new ArrayList<>();
        list.add(new TaskT<>(12));
        DoSomeThing doSomeThing = new DoSomeThing<Integer>(list);
        
        List<TaskT<String>> list2 = doSomeThing.getList();
        System.out.println(list2.get(0).getData());
    }

}
