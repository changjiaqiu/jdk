/*
 * Copyright (c) 2008, 2023, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

#ifndef JEANDLE_JDK_LLVM_HOTSPOT_MACROS_H
#define JEANDLE_JDK_LLVM_HOTSPOT_MACROS_H

#define STRINGIFY(x) #x
#define INCLUDE_HEADER(x) _Pragma(STRINGIFY(include x))

#define LLVM_HEADER_BEGIN \
    _Pragma("push_macro(\"AARCH64\")") \
    _Pragma("undef AARCH64") \
    INCLUDE_HEADER(<cassert>)

#define LLVM_HEADER_END \
    _Pragma("pop_macro(\"AARCH64\")") \
    INCLUDE_HEADER("utilities/debug.hpp")

#endif
