//import java.util.*;

class UnionSet{

    int[] parent;
    int[] size;
    int n;
    public UnionSet(int n){
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }


    public int find(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void merge(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return;
        }
        if(size[pa] > size[pb]){
            parent[pb] = pa;
            size[pa] += size[pb];
        }else{
            parent[pa] = pb;
            size[pb] += size[pa];
        }
    }

    public static void main(String[] args){
        UnionSet us = new UnionSet(7);
        us.merge(0,1);
        us.merge(2,3);
        us.merge(4,5);
        us.merge(4,6);
        us.merge(0,4);
        System.out.println(us.find(4)+" "+us.find(6));
        System.out.println(us.size[5]);

    }

}