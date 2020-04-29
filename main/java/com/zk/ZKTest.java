package com.zk;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;



public class ZKTest implements Watcher {
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zooKeeper;
	private static Stat stat=new Stat();
	public static void main(String [] args ) throws IOException, InterruptedException, KeeperException {
		zooKeeper = new ZooKeeper("localhost:2181", 5000, new ZKTest());
		countDownLatch.await();
		List<String> list = zooKeeper.getChildren("/", true);
		System.out.println(list);
		Thread.sleep(20000);
		System.out.println("���ӹر�....");
	}
	  public void process(WatchedEvent watchedEvent) {
	        //�����ǰ������״̬�����ӳɹ��ģ���ôͨ��������ȥ����
	        if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
	            if(Event.EventType.None==watchedEvent.getType()&&null==watchedEvent.getPath()){	
	                countDownLatch.countDown();
	                System.out.println(watchedEvent.getState()+"-->"+watchedEvent.getType());
	            }else if(watchedEvent.getType()== Event.EventType.NodeDataChanged){
	                try {
	                    System.out.println("���ݱ������·����"+watchedEvent.getPath()+"->�ı���ֵ��"+
	                            new String(zooKeeper.getData(watchedEvent.getPath(),true,stat)));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeChildrenChanged){//�ӽڵ�����ݱ仯�ᴥ��
	                try {
	                    System.out.println("�ӽڵ����ݱ��·����"+watchedEvent.getPath()+"->�ڵ��ֵ��"+
	                    		zooKeeper.getData(watchedEvent.getPath(),true,stat));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeCreated){//�����ӽڵ��ʱ��ᴥ��
	                try {
	                    System.out.println("�ڵ㴴��·����"+watchedEvent.getPath()+"->�ڵ��ֵ��"+
	                    		zooKeeper.getData(watchedEvent.getPath(),true,stat));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeDeleted){//�ӽڵ�ɾ���ᴥ��
	                System.out.println("�ڵ�ɾ��·����"+watchedEvent.getPath());
	            }
	        }

	    }
}
