<template>
  <div class="header">
    <Slider />
  </div>

  <div class="content">
    <IntroText introTextFirstWord="Willkommen" introTextTitle="beim Guitar Hearts Project">
      <p>Im März 2015 hat Lars die Idee, zwei seiner Gitarren für einen wohltätigen Zweck zu verschenken. Seine Aktion postet er bei Facebook. Hunderte Menschen, von armen Musikern bis zu Asylbewerbern, aber auch viele Schulen und Musikinitiativen schreiben ihn an.</p>
      <p>Es melden sich aber nicht nur Leute, die diese Gitarren haben wollen – sondern auch viele, die selbst alte Instrumente, Verstärker und Equipment für Bands verschenken oder sonst irgendwie diese tolle Idee unterstützen möchten. Und so wird aus einer Idee ein Projekt und aus dem Projekt letztendlich ein eingetragener, gemeinnütziger Verein (e.V.).</p>
    </IntroText>
    <div class="text-cards">
      <TextCard
          textCardFirstWord="Wie"
          textCardTitle="bewerbe ich mich auf ein Instrument vom Guitar Hearts Project?"
          :textCardImgSource="require('@/assets/images/BilderLars/IMG_20150318_174532_HDR_zugeschnitten_small.png')"
      >
        Klicke auf die Schaltfläche "Bewerben" oben auf dieser Website. So bekommst du einen direkten Kontakt zu uns. Schreibe uns eine Nachricht, in welcher du uns erzählst, warum genau DU eines unserer Instrumente bekommen solltest.
        Erzähl uns von deiner Leidenschaft zur Musik und natürlich auch ein bisschen was über dich.
        <br><br>
        Alle Vereinsmitglieder entscheiden gemeinsam, wer die Spende bekommt und planen die Übergaben. Wir verschicken keine Gitarren auf dem Postweg, sondern übergeben alle Instrumente persönlich, weil wir diese gut untergebracht wissen möchten.

      </TextCard>
      <TextCard
          textCardFirstWord="Welches"
          textCardTitle="Ziel verfolgt das Guitar Hearts Project?"
          :textCardImgSource="require('@/assets/images/BilderLars/IMG_20190323_125518_small.png')"
      >
        Wir bekamen den Namen Guitar Hearts Project und organisieren uns seit April 2017 als eingetragener gemeinnütziger Verein. Wir sammeln nun offiziell nicht mehr benötigte Gitarren, E-Bässe, sowie Amps und Equipment, richten diese in Eigenleistung wieder her und spenden die Instrumente an gemeinnützige Organisationen, Schulen, soziale Projekte und bedürftige Privatpersonen. Schon in den ersten Wochen bekamen wir knapp zwei Dutzend Instrumente und Equipment gespendet.
      </TextCard>
    </div>
    <div class="amazon-part">
    </div>
    <BlogOverview />
    <TextElement textElementFirstWord="Wie" textElementTitle="funktioniert das Guitar Hearts Project?">
      <p>Ein solches Projekt erfordert nicht nur einen großen organisatorischen Aufwand. Die gespendeten Gitarren müssen zum größten Teil optimiert, eingestellt oder oft auch repariert werden, bevor sie weiter gespendet werden können.</p>
      <p>Das bedeutet natürlich Arbeit, die Beschaffung von Ersatzteilen, Werkzeug, Saiten und so weiter.
      Bisher wurden alle damit verbundenen Kosten privat gedeckt. Langfristig erhoffen wir uns eine Finanzierung durch Geldspenden.</p>
    </TextElement>
    <Instruments />
  </div>

  <div class="footer">
    <Footer />
  </div>
</template>

<script>
// @ is an alias to /src
import Slider from "@/components/landing-page/Slider";
import IntroText from "@/components/landing-page/IntroText";
import TextCard from "@/components/landing-page/TextCard";
import TextElement from "@/components/landing-page/TextElement";
import Instruments from "@/components/landing-page/Instruments";
import Footer from "@/components/Footer";

export default {
  name: 'Home',
  components: {
    Footer,
    Instruments,
    TextElement,
    TextCard,
    IntroText,
    Slider
  }
}
</script>


<style scoped>
  .text-cards {
    display: flex;
  }
  .footer {
    display:flex;
    background-color: #000000;
    color: #ffffff;
  }
  .content {
    margin-left: 10vw;
    margin-right: 10vw;
    line-height: 1.5;
    font-size: 1.2rem;
  }
</style>