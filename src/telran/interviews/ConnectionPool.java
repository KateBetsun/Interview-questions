package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

//all methods should have 0[1] complexity
public class ConnectionPool {
	// DAta Structure
	LinkedHashMap<Long, Connection> pool;
	int size;
	
	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		
		this.size = size;
		pool = new LinkedHashMap<>(size, 0.75f, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> entry) {
				return size() > size;
			}
		};
	}
	public Connection getConnection(Connection connection) {
		// return a connection from the pool if it exists
		//otherwise creates new collection, add in pool and returns 
		// new created connections
		return pool.computeIfAbsent(connection.id(), id -> connection);
	}
	public boolean isInPool(long id) {
		// returns true if in a given connection exists in the pool
		//otherwise returns false
		return pool.containsKey(id);
	}
}
