/**  


**/
public static List<Order> getOrderList(List<Order_Dependency> orderDependencies){
    Map<String, Order> orderMap = new HashMap<String, Order>(); 
    Map<String, Integer> in_degree = new HashMap<String, Integer>(); 
    Map<String, Set<String>> graph = new HashMap<String, Set<String>>(); 
    for(Order_Dependency od : orderDependencies) {
        String order = od.order.name;
        String dept = od.dependent.name;
        orderMap.putIfAbsent(order, od.order); 
        orderMap.putIfAbsent(dept, od.dependent); 
        in_degree.putIfAbsent(order, 0);
        in_degree.putIfAbsent(dept, 0);
        if (!graph.containsKey(order) || !graph.get(order).contains(dept)){
            in_degree.put(dept, in_degree.get(dept) + 1);
        }
        graph.putIfAbsent(order, new HashSet<String>()); 
        graph.get(order).add(dept);
    }
    Queue<String> que = new LinkedList<String>(); 
    for(String key : in_degree.keySet()) {
        if(in_degree.get(key) == 0) {
            que.offer(key);
        }
    }
    List<Order> ans = new ArrayList<Order>(); 
    while(!que.isEmpty()) {
        String s = que.poll(); 
        ans.add(orderMap.get(s)); 
        Set<String> adjs = graph.get(s); 
        if(adjs == null) continue; 
        for(String adj : adjs) {
            if(in_degree.put(adj, in_degree.get(adj) - 1) == 1) { 
                que.offer(adj);
            }
        }
    }
    if(in_degree.size() != ans.size()) {
        return null; 
    }
    return ans;