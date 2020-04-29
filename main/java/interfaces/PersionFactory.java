package interfaces;

import domain.Persion;

public interface PersionFactory<P extends Persion> {
	
    P createPersion(String name,String address);
}
