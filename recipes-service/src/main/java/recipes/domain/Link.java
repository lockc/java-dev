package recipes.domain;

import java.net.URI;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link {
	
    private String relation;
	private URI target;

	@XmlAttribute(name = "rel")
    public String getRelation() {
        return relation;
    }

    public Link setRelation(String relation) {
        this.relation = relation;
        return this;
    }

	@XmlAttribute(name = "href")
    public URI getTarget() {
        return target;
    }

    public Link setTarget(URI target) {
        this.target = target;
        return this;
    }
//
//    @Override
//	public int hashCode() {
//		return new HashCodeBuilder()
//                .append(target)
//                .append(relation)
//                .toHashCode();
//	}
//
//    @Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Link)){
//            return false;
//        }
//
//        if (this == obj){
//            return true;
//        }
//
//        Link other = (Link) obj;
//
//        return new EqualsBuilder()
//                .append(target,other.getTarget())
//                .append(relation, other.getRelation())
//                .isEquals();
//	}
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see java.lang.Object#toString()
//     */
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("relation", getRelation()).append("target", getTarget()).toString();
//    }
}


