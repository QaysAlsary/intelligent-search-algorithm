import java.util.*;
public class Logic {

long start,end;
double time;
    public void BFS(structure str){
        start=System.currentTimeMillis();
         ArrayList<structure> visited=new ArrayList<>();
         Queue<structure> queue = new LinkedList<structure>();
        queue.add(str);
        visited.add(str);
        int counter=0;
        int counter1=0;
        int depth=0;
        while (!queue.isEmpty()){
//         System.out.println("-------------this one from the while loop--------------------");

           str =queue.remove();
//            depth--;
            if(str.isFinshed(str)==true){
                str.print(str);
                System.out.println("/////////////////////////////Finished/////////////////////////////////////////");
                do{
                    counter1++;
                str=str.parent;
                    depth++;
                str.print(str);
                }
                while(str.parent!=null);
                System.out.println(counter1+ " number of solution path nodes ");
                System.out.println(counter + " visited node");
                System.out.println(depth + " solution depth");
                end=System.currentTimeMillis();
                time=(end-start)/1000.0;
                System.out.println(time+" seconds");
                return;
            }


        else{
                for(structure structure : str.getNextState(str)){
                    structure.print(structure);
//                    System.out.println("++++++++++++++++++++++++++this one from the for loop++++++++++++++++++++++++++++++");
                    int hash=structure.hashCode();
                    if(!structure.isEqual(visited,structure)){
                        visited.add(structure);
                        queue.add(structure);


                    }
                }

            }
        counter++;
        }

    }

    public void DFS(structure str){
        start=System.currentTimeMillis();
//        HashSet<Integer> visited =new HashSet<>();
        ArrayList<structure> visited=new ArrayList<>();
        Stack<structure> stack =new Stack();
        stack.push(str);

        int counter=0;
        int counter1=0;
        int depth=0;
        while(!stack.isEmpty()){
            str=stack.pop();

            if(str.isFinshed(str)==true){
             str.print(str);
                System.out.println("/////////////////////////////Finished/////////////////////////////////////////");

                do{
                 counter1++;
                 str=str.parent;
                    depth++;
                 str.print(str);
             }
                while(str.parent !=null);
                System.out.println(counter1+ " number of solution path nodes ");
                System.out.println(counter + " visited node");
                System.out.println(depth + " solution depth");
                end=System.currentTimeMillis();
                time=(end-start)/1000.0;
                System.out.println(time+" seconds");
                return;
            }else{
                visited.add(str);
                for(structure structure : str.getNextState(str)){
                    int hash=structure.hashCode();
                    if(!structure.isEqual(visited,structure)){


                        stack.push(structure);


                    }
                }
                counter++;
            }


        }

    }
//    public void UCS(structure str){
//        Queue<structure> queue =new PriorityQueue<>(new MyCpmprator());
//        Map<structure,Integer> map=new HashMap<>();
//        int counter=0;
//        boolean solved=false;
//        int cost;
//        int c=0;
//        str.parent=null;
//        queue.add(str);
//        str.cost=0;
//        str.depth=0;
//        while(!queue.isEmpty()||solved!=true){
//            str=queue.poll();
//            if(str.isFinshed(str)){
//                solved=true;
//                System.out.println("////////////////////////////////////FINISHED////////////////////////////////////////////");
//                str.print(str);
//                System.out.println(str.cost);
//                int depth=str.depth;
//                do{
//                    str=str.parent;
//                    str.print(str);
//                    c++;
//                    System.out.println(str.cost);
//                }while(str.parent!=null);
//                System.out.println(counter+" visited node");
//                System.out.println(depth+" solution depth");
//                System.out.println(c+" solution depth nodes");
//                return;
//            }
//            counter++;
//            map.put(str,str.cost);
//            ArrayList arr =str.getNextState(str);
//            if(!arr.isEmpty()){
//                for(int i=0;i<arr.size();i++){
//                    structure structure= (structure) arr.get(i);
//                    if(!map.containsKey(structure)){
//                        queue.add(structure);
//                        structure.parent=str;
//                        structure.cost=str.cost+1;
//                        structure.depth=str.depth+1;
//                        for(Map.Entry<structure,Integer> m:map.entrySet()){
//                            if(m.getKey().equal( m.getKey(), structure)){
//                                if(m.getValue()<structure.cost){
//                                    queue.remove(structure);
//                                }
//                                if(m.getValue()>structure.cost){
////                                queue.remove(structure);
////                                    queue.add(structure);
//                                    m.setValue(structure.cost);
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//    }
    public void UCS(structure s1){
        ArrayList<structure> visited =new ArrayList<>();
        Queue<structure> queue =new PriorityQueue<>(new MyCpmprator());
        long start=System.currentTimeMillis();
        structure str =s1;

        int counter=0;
        boolean done=false;
        queue.add(str);
        while(!queue.isEmpty() || done==false){
            str=queue.poll();
            if(str.isFinshed(str)==true){
                done=true;
                str.print(str);
                System.out.println(" the cost: "+str.cost);
                int count=0,depth=str.depth;
                do{
                    System.out.println("//////////////////////////////////////");
                    str=str.parent;
                    str.print(str);
                    count++;
                    System.out.println(" the cost: "+str.cost);
                }
                while(str.parent!=null);
                long end= System.currentTimeMillis();

                System.out.println(counter+" visited node");
                System.out.println(depth+" solution depth");
                System.out.println(count+" solution depth nodes");
                time=(end-start)/1000.0;
                System.out.println(time+" seconds");
                break;
            }
            else{
                counter++;
                visited.add(str);
                for(structure st : str.getNextState(str)){
                    st.cost=str.cost+1;
                    st.depth=str.depth+1;
                    st.parent=str;
                    if(st.equall(visited,st)==false&&existinQ(queue,st)==false){
                        queue.add(st);
                    }
                    else{
                        for(structure s2 : visited){
                            if(st.equal(s2,st)==true){
                                if(s2.cost > st.cost){
                                    s2.cost=st.cost;
                                    s2.h=st.h;
                                }
                            }
                        }
                    }
                }
            }
        }


    }
    public void aStar(structure s1){
        ArrayList<structure> visited =new ArrayList<>();
        Queue<structure> queue =new PriorityQueue<>(new aStarComparator());
        long start=System.currentTimeMillis();
        structure str =s1;
        str.h=heuristic(str);
        int counter=0;
        boolean done=false;
        queue.add(str);
        while(!queue.isEmpty() || done==false){
            str=queue.poll();
            if(str.isFinshed(str)==true){
                done=true;
                str.print(str);
                System.out.println(" the cost: "+str.cost);
                int count=0,depth=str.depth;
                do{
                    System.out.println("//////////////////////////////////////");
                    str=str.parent;
                    str.print(str);
                    count++;
                    System.out.println(" the cost: "+str.cost);
                }
                while(str.parent!=null);
                long end= System.currentTimeMillis();

                System.out.println(counter+" visited node");
                System.out.println(depth+" solution depth");
                System.out.println(count+" solution depth nodes");
                time=(end-start)/1000.0;
                System.out.println(time+" seconds");
                break;
            }
            else{
                counter++;
                visited.add(str);
                for(structure st : str.getNextState(str)){
                    st.cost=str.cost+1;
                    st.depth=str.depth+1;
                    st.parent=str;
                    st.h=heuristic(st);
                    if(st.equall(visited,st)==false&&existinQ(queue,st)==false){
                        queue.add(st);
                    }
                    else{
                        for(structure s2 : visited){
                            if(st.equal(s2,st)==true){
                                if(s2.cost > st.cost){
                                    s2.cost=st.cost;
                                    s2.h=st.h;
                                }
                            }
                        }
                    }
                }
            }
        }


    }
    public int heuristic (structure str){
        int h=0;
        for(int i=0;i<str.n;i++){
            for(int j=0;j<str.n;j++){
                if(str.array[i][j]=='R')
                    h+=2;
            }
        }
        return h*2;
    }
    public boolean existinQ(Queue<structure> queue,structure s){

        for(structure str : queue){
            if(str.equal(str,s))
                return true;
        }
        return false;
    }
//    public int heuristc(structure str){
//        int i,j;
//        int h=0;
//        for( i = 0; i < str.n; ++i) {
//            for(j = 0; j < str.n&&i!=str.n-1&&j!=str.n-1; ++j) {
//                if(str.array[i][j] == 'B'){
//                    h++;
//                }
//            }
//        }
//
//        for(i = str.n - 1; i < str.n * 2 - 1; ++i) {
//            for(j = str.n-1 ; j < str.n * 2 - 1&&i!=str.n-1&&j!=str.n-1; ++j) {
//                if(str.array[i][j] == 'R'){
//                    h++;
//                }
//            }
//        }
//        return h;
//    }
//    public void dfs(structure str ){
//        start=System.currentTimeMillis();
//      HashSet<Integer> visited =new HashSet<>();
////        ArrayList<structure> visited=new ArrayList<>();
//        Stack<structure> stack =new Stack();
//        stack.push(str);
//        visited.add(str.hashCode());
//        int counter=0;
//        int counter1=0;
//        int depth=0;
//        while(!stack.isEmpty()){
//            str=stack.pop();
//            depth--;
//            if(str.isFinshed(str)==true){
//                str.print(str);
//                System.out.println("/////////////////////////////Finished/////////////////////////////////////////");
//
//                do{
//                    str=str.parent;
//                    str.print(str);
//                }
//                while(str.parent !=null);
//                System.out.println(counter1+ " number of solution path nodes ");
//                System.out.println(counter + " visited node");
//                System.out.println(depth + " solution depth");
//                end=System.currentTimeMillis();
//                time=(end-start)/1000.0;
//                System.out.println(time+" seconds");
//                return;
//            }else{
//                for(structure structure : str.getNextState(str)){
//                    int hash=structure.hashCode();
//                    if(!visited.contains(hash)){
//                        visited.add(structure.hashCode());
//                        stack.push(structure);
//                        depth++;
//
//                    }
//                }
//            }
//
//            counter++;
//        }
//    }

//    public void UCS(structure str){
//        Queue<structure> queue =new PriorityQueue<>(new MyCpmprator());
//        Map<structure,Integer> map=new HashMap<>();
//        int counter=0;
//        boolean solved=false;
//        int cost;
//        str.parent=null;
//        queue.add(str);
//        str.cost=0;
//        str.depth=0;
//        while(!queue.isEmpty()){
//            str=queue.poll();
//            if(str.isFinshed(str)){
////                solved=true;
//                System.out.println("////////////////////////////////////FINISHED////////////////////////////////////////////");
//                str.print(str);
//                System.out.println(str.cost);
//                int depth=str.depth;
//                do{
//                    str=str.parent;
//                    str.print(str);
//                    System.out.println(str.cost);
//                }while(str.parent!=null);
//                System.out.println(counter+" visited node");
//                System.out.println(depth+" solution depth");
//                return;
//            }
//            counter++;
//            map.put(str,str.cost);
//            ArrayList arr =str.getNextState(str);
//            if(!arr.isEmpty()){
//                for(int i=0;i<arr.size();i++){
//                    structure structure= (structure) arr.get(i);
//                    queue.add(structure);
//                    structure.parent=str;
//                    structure.cost=str.cost+1;
//                    structure.depth=str.depth+1;
//                    for(Map.Entry<structure,Integer> m:map.entrySet()){
//                        if(m.getKey().equal( m.getKey(), structure)){
//                            if(m.getValue()<structure.cost){
//                                queue.remove(structure);
//                            }
//                            if(m.getValue()>structure.cost){
//                                queue.remove(structure);
//                                m.setValue(structure.cost);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
