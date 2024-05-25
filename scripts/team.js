require("planetarium");


const target = "manifold";
const baseColor = Color.valueOf("6d7acf");
let palette = [
Color.valueOf("544ba6"),
baseColor,
Color.valueOf("6d7acf")
];
let palettei = [
Color.valueOf("c6d4ff").rgba(),
baseColor.rgba(),
Color.valueOf("606d90").rgba()
];

Events.on(ContentInitEvent, () => {

  let fonts = [Fonts.def, Fonts.outline];
  let ch = Fonts.getUnicode(target);

  let size = Mathf.round(Fonts.def.getData().lineHeight / Fonts.def.getData().scaleY);
  let tex = Core.atlas.find("implosion-team-Abyss");
  let out = Scaling.fit.apply(tex.width, tex.height, size, size);

  for(let font of fonts){
    let list = Reflect.get(Font, font, "regions");
    list.add(tex);
    Reflect.set(Font, font, "regions", list);

    let glyph = font.getData().getGlyph(ch);
    glyph.page = 1;
    glyph.id = ch;
    glyph.srcX = glyph.srcY = 0;
    glyph.width = 62
    glyph.height = 62
    glyph.u = tex.u;
    glyph.v = tex.v2;
    glyph.u2 = tex.u2;
    glyph.v2 = tex.v;
    glyph.xoffset = 0;
    glyph.yoffset = -size;
    glyph.xadvance = size;
    glyph.kerning = null;
    glyph.fixedWidth = true;

    //font.getData().setGlyphRegion(glyph, tex);
  }

  const Abyss = Team.get(5);
  Abyss.name = "Abyss";
  Reflect.set(Team, Abyss, "color", baseColor);

  let newPal = Reflect.get(Team, Abyss, "palette");
  newPal[0] = palette[0];
  newPal[1] = palette[1];
  newPal[2] = palette[2];
  Reflect.set(Team, Abyss, "palette", newPal);
  let newI = Reflect.get(Team, Abyss, "palettei");
  newI[0] = palettei[0];
  newI[1] = palettei[1];
  newI[2] = palettei[2];
  Reflect.set(Team, Abyss, "palettei", newI);

  Abyss.hasPalette = true;
  Abyss.emoji = Fonts.getUnicodeStr(target);
});

//thanks abreaker.#0 for team code
