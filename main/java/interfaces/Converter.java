package interfaces;
//��ע���ڷ��ֽӿ����ж���һ�����󷽷���ʱ��ᱨ��
//����ʽ�ӿ�,ֻ����һ���ӿ�ֻӵ��һ������ķ����ǲŻ���Ч
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F form);

}
