package annotation;

/**
 *  * @Override:
 * * @Deprecated: 表示该注解标注的内容已经过时
 * * @SuppressWarning: 压制警告
 */
@SuppressWarnings("all")
@MyAnno(value = 1, p = Person.p1, anno2 = @MyAnno2, strs={"1", "2"})
public class AnnoDemo2 {
}
