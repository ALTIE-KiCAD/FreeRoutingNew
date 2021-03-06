package board.awtree;
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


/**
 * Information of a single object stored in a tree
 */
public final class AwtreeEntry
   {
   public final AwtreeObject object;
   public final int shape_index_in_object;

   public AwtreeEntry(AwtreeObject p_object, int p_shape_index_in_object)
      {
      object = p_object;
      shape_index_in_object = p_shape_index_in_object;
      }
   }
