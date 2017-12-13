package edu.mum.cinema.dto;

public class SectionTemplate {
    private String id;
    private String sectionLabel;
    private String layoutTemplateId;
    
    public SectionTemplate(){}
    public SectionTemplate(String id, String sectionLabel, String layoutTemplateId){
        this.id = id;
        this.sectionLabel = sectionLabel;
        this.layoutTemplateId = layoutTemplateId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public void setSectionLabel(String sectionLabel) {
        this.sectionLabel = sectionLabel;
    }

    public String getLayoutTemplateId() {
        return layoutTemplateId;
    }

    public void setLayoutTemplateId(String layoutTemplateId) {
        this.layoutTemplateId = layoutTemplateId;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((layoutTemplateId == null) ? 0 : layoutTemplateId.hashCode());
		result = prime * result + ((sectionLabel == null) ? 0 : sectionLabel.hashCode());
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
		SectionTemplate other = (SectionTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (layoutTemplateId == null) {
			if (other.layoutTemplateId != null)
				return false;
		} else if (!layoutTemplateId.equals(other.layoutTemplateId))
			return false;
		if (sectionLabel == null) {
			if (other.sectionLabel != null)
				return false;
		} else if (!sectionLabel.equals(other.sectionLabel))
			return false;
		return true;
	}
    
    
}

