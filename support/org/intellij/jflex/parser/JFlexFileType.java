/*
 * Copyright 2011-2014 Gregory Shrago
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.jflex.parser;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.StdFileTypes;
import org.intellij.jflex.JFlexLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class JFlexFileType extends LanguageFileType {

  public static final JFlexFileType INSTANCE = new JFlexFileType();

  protected JFlexFileType() {
    super(JFlexLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "JFlex";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "JFlex lexer";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "flex";
  }

  @Override
  public Icon getIcon() {
    return StdFileTypes.PLAIN_TEXT.getIcon();
  }
}
