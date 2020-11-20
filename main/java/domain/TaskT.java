package domain;

public class TaskT<T>
{
        public T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
        
        public TaskT(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TaskT [data=" + data + "]";
        }
        

}
