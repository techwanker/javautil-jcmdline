package org.javautil.json;

import java.util.Date;

public class TestBean {
			private final Date date;
			private final String string;
					private final int intInstance;
			public TestBean(Date date, String string, int intInstance) {
				super();
				this.date = date;
				this.string = string;
				this.intInstance = intInstance;
			}
			public Date getDate() {
				return date;
			}
			public String getString() {
				return string;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((date == null) ? 0 : date.hashCode());
				result = prime * result + intInstance;
				result = prime * result + ((string == null) ? 0 : string.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				TestBean other = (TestBean) obj;
				if (date == null) {
					if (other.date != null)
						return false;
				} else if (!date.equals(other.date))
					return false;
				if (intInstance != other.intInstance)
					return false;
				if (string == null) {
                    return other.string == null;
				} else return string.equals(other.string);
            }
			public int getIntInstance() {
				return intInstance;
			}
		}
		