/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This will list core deatils of properties within a list.
 * This list will be composed of multiple boxes with different properties.
 *
 * Each of these properties will be contained within a clickable button, which
 * will update the display to show more details about the property.
 */
package gui.elements;

import gui.FocusPanel;

import java.util.ArrayList;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ElementList<T extends Component> extends JPanel {
	private ArrayList<T> propertyList;
	private GridBagLayout panelLayout;
	private JPanel contentList;
	private JScrollPane scrollPane;

	public ElementList() {
		super();
		this.propertyList = new ArrayList<T>();
		init();
	}

	public ElementList(T[] propertyList) {
		super();
		this.propertyList = new ArrayList<T>();

		for (int index = 0; index < propertyList.length; index++) {
			this.propertyList.add(propertyList[index]);
		}

		init();
	}

	/**
	 * Updates propertyList with a new array of properties to show.
	 *
	 * @param propertyList A list of buttons representing different properties.
	 */
	public void updateList(ArrayList<T> propertyList) {
		clear();
		this.propertyList = propertyList;
	}

	/**
	 * Updates propertyList with a new array of properties to show.
	 *
	 * @param propertyList A list of buttons representing different properties.
	 */
	public void updateList(T[] propertyList) {
		clear();
		this.propertyList = new ArrayList<T>();

		for (int index = 0; index < propertyList.length; index++) {
			this.propertyList.add(propertyList[index]);
		}
	}

	/**
	 * Initializes the current property list
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// create necessary element
		contentList = new JPanel();
		GridBagLayout listLayout = new GridBagLayout();
		contentList.setLayout(panelLayout);

		update();

		scrollPane = new JScrollPane(contentList);

		// populate elements in their respective containers
		GridBagConstraints gbc;
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(scrollPane, gbc);
		gbc.weighty = 0;
	}

	/**
	 * Updates the current list to whatever propertyList is.
	 */
	private void update() {
		// add every property to list
		for (int propertyPos = 0; propertyPos < propertyList.size(); propertyPos++) {
			T currProperty = propertyList.get(propertyPos);
			GridBagConstraints gbc = FocusPanel.generateConstraints(0, propertyPos, 1, 1);

			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 0.9;
			contentList.add(currProperty, gbc);
		}
	}

	/**
	 * Clears current list.
	 */
	private void clear() {
		for (T property : propertyList) {
			remove(property);
		}
	}
}
