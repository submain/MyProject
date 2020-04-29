package interfaces;
//该注解在发现接口中有多余一个抽象方法的时候会报错
//函数式接口,只有在一个接口只拥有一个抽象的方法是才会生效
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F form);

}
