package BE;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class GUIHelper {

    /**
     * Create a BorderPane scene element for the given Student.
     *
     * @param student The student to create a BorderPane for.
     * @param font    The font to use for the first and last name.
     * @param width   The width for the student's picture.
     * @param height  The height for the student's picture.
     * @return Returns the created BorderPane. Null if the student is null.
     */
    public static BorderPane createStudentBorderPane(Student student, Font font, double width, double height, String style) {
        if (student != null) {
            var pane = new BorderPane();

            // Get the student's first and last name as well as picture path.
            Text studentName = new Text(String.format("%s \n%s", student.getFirstName(), student.getLastName()));
            studentName.setFont(font);
            ImageView picture = new ImageView(new File(student.getPicture()).toURI().toString());
            picture.setPreserveRatio(true);
            picture.setFitWidth(width);
            picture.setFitHeight(height);

            // Adjust to fit the BorderPane.
            BorderPane.setAlignment(studentName, Pos.TOP_CENTER);
            BorderPane.setAlignment(picture, Pos.CENTER);

            // Add the elements (nodes) to the BorderPane.
            pane.setTop(studentName);
            pane.setCenter(picture);

            // Adding styling.
            pane.setStyle(style);
            pane.setPadding(new Insets(8, 8, 8, 8));
            FlowPane.setMargin(pane, new Insets(10, 10, 10, 10));

            // Assign an id.
            pane.setAccessibleText(String.format("%d", student.getId()));

            // Return the created BorderPane.
            return pane;
        }
        return null;
    }
}