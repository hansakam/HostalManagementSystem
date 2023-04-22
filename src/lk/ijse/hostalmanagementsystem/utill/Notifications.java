/**
 * @author :Hansaka Malshan
 * created 4/22/2023---12:04 PM
 */
package lk.ijse.hostalmanagementsystem.utill;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Notifications {

    public static  void showNotification(String url,String title,String text){
        Image image=new Image(url);
        org.controlsfx.control.Notifications notifications= org.controlsfx.control.Notifications.create();
        notifications .title(title);
        notifications  .text(text);
        notifications    .graphic(new ImageView(image));
        notifications  .hideAfter(Duration.seconds(3));
        notifications    .position(Pos.BOTTOM_RIGHT);
        notifications.darkStyle();
        notifications.show();
    }
}
