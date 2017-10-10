package com.github.quantrresearch.sharepoint.online;

import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;

public class SharePointTreeNode extends DefaultMutableTreeNode {

	String type;
	String text;
	String icon;
	public boolean visible;
	static HashMap<String, Icon> iconRoot;
	Object object;

	static {
		iconRoot = new HashMap<>();
		Reflections reflections = new Reflections("com.github.quantrresearch.sharepoint.online.icon", new ResourcesScanner());
		Set<String> fileNames = reflections.getResources(Pattern.compile(".*\\.png"));
		for (String filepath : fileNames) {
			String filename = new File(filepath).getName();
			iconRoot.put(filename, new ImageIcon(SharePointTreeNode.class.getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon/" + filename)));
		}
	}

	public SharePointTreeNode(String text, String type) {
		this(text, type, null, null);
	}

	public SharePointTreeNode(String text, String type, String icon, Object object) {
		super();
		this.text = text;
		this.type = type;
		this.icon = icon;
		if (this.icon != null && !this.icon.endsWith(".png")) {
			this.icon += ".png";
		}
		this.object = object;
		visible = true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Icon getIcon() {
		Icon temp = iconRoot.get(icon);
		System.out.println(icon + " = " + temp);
		return temp;
	}

	public String toString() {
		return text;
	}

}
