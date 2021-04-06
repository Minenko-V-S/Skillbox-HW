
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import structure.Courses;



import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static Object beanManagerFromSomewhere;

    public static void main(String[] args) {

        try (
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();
        ) {
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder()
                    .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                    .build();





            try (
                    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                            .applyBeanManager( getBeanManagerFromSomewhere() )
                            .build();
                    Session session = sessionFactory.openSession();
            ) {
                Courses course = session.get(Courses.class, 46);
                checkedCourse(session, course);

                getCorses(session).forEach(System.out::println);

            } catch (Exception e) {
                System.out.println("Ошибка чтения БД");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Stream<Courses> getCorses(Session session) {
        try {
            Query query = session.createQuery("FROM Courses", Courses.class);
            List<Courses> list = query.list();
            return list.stream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.<Courses>emptyList().stream();
    }

    private static void checkedCourse(Session session, Courses course) {
        Transaction transaction = session.beginTransaction();

        if (course.getDescription() == null) {
            course.setDescription("placeholder");
        }

        if (course.getStudentsCount() == null) {
            course.setStudentsCount((int) Math.random());
        }


        transaction.commit();
        session.clear();
    }

    public static Object getBeanManagerFromSomewhere() {
        return beanManagerFromSomewhere;
    }
}