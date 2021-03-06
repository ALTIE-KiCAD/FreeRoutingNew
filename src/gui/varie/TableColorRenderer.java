package gui.varie;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/*
 *  Copyright (C) 2014  Damiano Bolla  website www.engidea.com
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License at <http://www.gnu.org/licenses/> 
 *   for more details.
 *
 */


public class TableColorRenderer extends JLabel implements TableCellRenderer
   {
   private static final long serialVersionUID = 1L;

   Border unselectedBorder = null;
   Border selectedBorder = null;
   boolean isBordered = true;

   public TableColorRenderer(boolean p_is_bordered)
      {
      super();
      this.isBordered = p_is_bordered;
      setOpaque(true); // MUST do this for background to show up.
      }

   public Component getTableCellRendererComponent(JTable p_table, Object p_color, boolean p_is_selected, boolean p_has_focus, int p_row, int p_column)
      {
      setBackground((Color) p_color);
      if (isBordered)
         {
         if (p_is_selected)
            {
            if (selectedBorder == null)
               {
               selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, p_table.getSelectionBackground());
               }
            setBorder(selectedBorder);
            }
         else
            {
            if (unselectedBorder == null)
               {
               unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, p_table.getBackground());
               }
            setBorder(unselectedBorder);
            }
         }
      return this;
      }
   }