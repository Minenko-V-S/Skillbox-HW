package structure;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {
    private Timestamp subscriptionDate;
    private String id;

    @Basic
    @Column(name = "subscription_date", nullable = false)
    public Timestamp getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriptions that = (Subscriptions) o;

        if (subscriptionDate != null ? !subscriptionDate.equals(that.subscriptionDate) : that.subscriptionDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return subscriptionDate != null ? subscriptionDate.hashCode() : 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
