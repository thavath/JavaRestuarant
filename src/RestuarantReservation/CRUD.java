package RestuarantReservation;

import java.util.List;

public interface CRUD<T> {
	public void create(T item);
	public List<T> read();
	public void update(T item);
	public void delete(T item);
}
