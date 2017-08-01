package in.itechvalley.indianagent.Model;

/**
 * Created by pranav on 25/07/2017.
 */

public class GetterSetter
{
    int imgResourceId, itemPosition;
    String Title, Subtitle;


    public GetterSetter(int imgResourceId, String title, String subtitle, int itemPosition)
    {
        this.imgResourceId = imgResourceId;
        Title = title;
        Subtitle = subtitle;
        itemPosition = itemPosition;
    }


    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getSubtitle()
    {
        return Subtitle;
    }

    public void setSubtitle(String subtitle)
    {
        Subtitle = subtitle;
    }

    public int getImgResourceId()
    {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId)
    {
        this.imgResourceId = imgResourceId;
    }

    public int getItemPosition()
    {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition)
    {
        this.itemPosition = itemPosition;
    }


}
