package bitwise;

public class Permission {
	// �Ƿ������ѯ�������Ƶ�1λ��0��ʾ��1��ʾ��  
    public static final int ALLOW_SELECT = 1 << 0; // 0001  = 1
      
    // �Ƿ����������������Ƶ�2λ��0��ʾ��1��ʾ��  
    public static final int ALLOW_INSERT = 1 << 1; // 0010  = 2
      
    // �Ƿ������޸ģ������Ƶ�3λ��0��ʾ��1��ʾ��  
    public static final int ALLOW_UPDATE = 1 << 2; // 0100  =4
      
    // �Ƿ�����ɾ���������Ƶ�4λ��0��ʾ��1��ʾ��   
    public static final int ALLOW_DELETE = 1 << 3; // 1000  = 8
    // �洢Ŀǰ��Ȩ��״̬  
    private int flag; 
    //�����û���Ȩ��
    public void setPer(int per) {
    	flag = per;
    }
    //�����û���Ȩ�ޣ�1�����߶����
    public void enable(int per) {
    	flag = flag|per;
    }
  //ɾ���û���Ȩ�ޣ�1�����߶����
    public void disable(int per) {
    	flag = flag&~per;
    }
    //�ж��û���Ȩ��
    public boolean isAllow(int per) {
    	return ((flag&per)== per);
    }
    //�ж��û�û�е�Ȩ��
    public boolean isNotAllow(int per) {
    	return ((flag&per)==0);
    }
  
    public static void main(String[] args) {
		int flag = 15;
		Permission permission = new Permission();
		permission.setPer(flag); 
		permission.disable(ALLOW_DELETE|ALLOW_INSERT);  
		System.out.println("select = "+permission.isAllow(ALLOW_SELECT));
		System.out.println("update = "+permission.isAllow(ALLOW_UPDATE));
		System.out.println("insert = "+permission.isAllow(ALLOW_INSERT));
		System.out.println("delete = "+permission.isAllow(ALLOW_DELETE));
		
		
	}
}
