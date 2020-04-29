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
		System.out.println("连接关闭....");
	}
	  public void process(WatchedEvent watchedEvent) {
	        //如果当前的连接状态是连接成功的，那么通过计数器去控制
	        if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
	            if(Event.EventType.None==watchedEvent.getType()&&null==watchedEvent.getPath()){	
	                countDownLatch.countDown();
	                System.out.println(watchedEvent.getState()+"-->"+watchedEvent.getType());
	            }else if(watchedEvent.getType()== Event.EventType.NodeDataChanged){
	                try {
	                    System.out.println("数据变更触发路径："+watchedEvent.getPath()+"->改变后的值："+
	                            new String(zooKeeper.getData(watchedEvent.getPath(),true,stat)));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeChildrenChanged){//子节点的数据变化会触发
	                try {
	                    System.out.println("子节点数据变更路径："+watchedEvent.getPath()+"->节点的值："+
	                    		zooKeeper.getData(watchedEvent.getPath(),true,stat));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeCreated){//创建子节点的时候会触发
	                try {
	                    System.out.println("节点创建路径："+watchedEvent.getPath()+"->节点的值："+
	                    		zooKeeper.getData(watchedEvent.getPath(),true,stat));
	                } catch (KeeperException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }else if(watchedEvent.getType()== Event.EventType.NodeDeleted){//子节点删除会触发
	                System.out.println("节点删除路径："+watchedEvent.getPath());
	            }
	        }

	    }
}
